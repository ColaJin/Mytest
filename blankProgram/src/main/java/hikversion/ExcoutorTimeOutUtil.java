package hikversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.*;

public class ExcoutorTimeOutUtil {
	private static Logger log = LoggerFactory.getLogger(ExcoutorTimeOutUtil.class);

	// 批量任务超时获取返回值，超时 ,lc的大小是并发线程的大小
	public static <T> List<T> excoutorTimeout(List<Callable<T>> lc, long timeout) {
		List<T> res = new ArrayList<>();
		int num = lc.size();
		if (num<1) return res;
		ExecutorService executor = createSameMaxCoreThreadPoolExecutor( num,"dms-ExcoutorTimeOutUtil-");

		List<Future<T>> lf = new ArrayList<Future<T>>();
		for (Callable<T> c : lc) {
			Future<T> future = executor.submit(c);
			lf.add(future);
		}
		try {
			executor.shutdown();
			if (executor.awaitTermination(timeout, TimeUnit.SECONDS)) {
				System.out.println("task finished");
			}
			for (Future<T> f : lf) {
				if (!f.isDone()) {
					System.out.println("task time out,will terminate");
					f.cancel(true);
				} else {
					try {
						res.add(f.get());
					} catch (ExecutionException e) {
						System.out.println( "excoutorTimeout fail");
						f.cancel(true);

					}
				}
			}

		} catch (InterruptedException e) {
			System.out.println("excoutorTimeout fail");
		} finally {
			executor.shutdownNow();
		}
		return res;
	}

	// 批量任务超时获取返回值，超时 ,lc的大小是并发线程的大小
	public static <T> Map<String, T> excoutorTimeout(Map<String, Callable<T>> lc, long timeout) {
		Map<String, T> res = new HashMap<>();
		int num = lc.size();
		if (num<1) return res;
		ExecutorService executor = createSameMaxCoreThreadPoolExecutor( num,"dms-ExcoutorTimeOutUtil-");
		Map<String, Future<T>> mf = new HashMap<>();
		for (Entry<String, Callable<T>> mc : lc.entrySet()) {
			Future<T> future = executor.submit(mc.getValue());
			mf.put(mc.getKey(), future);
		}
		try {
			executor.shutdown();
			if (executor.awaitTermination(timeout, TimeUnit.SECONDS)) {
				System.out.println("task finished");
			}
			for (Entry<String, Future<T>> f : mf.entrySet()) {
				if (!f.getValue().isDone()) {
					System.out.println("task time out,will terminate");
					f.getValue().cancel(true);
					res.put(f.getKey(), null);
				} else {
					try {
						res.put(f.getKey(), f.getValue().get());
					} catch (ExecutionException e) {
						System.out.println( "excoutorTimeout fail");
						f.getValue().cancel(true);
					}
				}
			}

		} catch (InterruptedException e) {
			System.out.println("excoutorTimeout fail");
		} finally {
			executor.shutdownNow();
		}
		return res;
	}

//	public static void main(String[] args) {
//		Map<String, Callable<JSONObject>> tasks = new HashMap<>();
//		for (int i =0;i<100;i++) {
//			Callable<JSONObject> task = new Callable<JSONObject>() {
//				@Override
//				public  JSONObject call() throws Exception {
//					JSONObject res  = new JSONObject();
//					res.put("i", "");
//				return res;
//				}
//			};
//			tasks.put(i+"",task);
//		}
//		excoutorTimeout(tasks,5,20);
//	}

	// 批量任务超时获取返回值，超时 ,lc的大小是并发线程的大小
	public static <T> Map<String, T> excoutorTimeout(Map<String, Callable<T>> lc, long timeout, int max) {
		int num = lc.size();
		Map<String, T> res = new HashMap<>();
		Map<String, Callable<T>> temp = new HashMap<>();
		if (num > max) {
			int i = 0;
			for (Entry<String, Callable<T>> entry : lc.entrySet()) {
				if (i % max == max - 1) {
					temp.put(entry.getKey(), entry.getValue());
					Map<String, T> restemp = excoutorTimeout(temp, timeout);
					temp.clear();
					res.putAll(restemp);
				} else {
					temp.put(entry.getKey(), entry.getValue());
				}
				i++;
				if (i >= num) {
					Map<String, T> restemp = excoutorTimeout(temp, timeout);
					res.putAll(restemp);
				}
			}
		} else {
			res = excoutorTimeout(lc, timeout);
		}
		return res;
	}

	public static ExecutorService createSameMaxCoreThreadPoolExecutor(int num,String name){
		return new ThreadPoolExecutor(num, num, 1, TimeUnit.SECONDS, new SynchronousQueue<>(),
				new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						Thread t = Executors.defaultThreadFactory().newThread(r);
						t.setDaemon(true);
						t.setName(name + t.getName());
						return t;
					}
				});
	}

//	public static void main(String[] args) {
//		String[] ss = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,".split(",");
//		List<Callable<String>> lc = new ArrayList<>();
//		for (String s : ss) {
//			Callable<String> c = new Callable<String>() {
//				@Override
//				public String call() throws Exception {
//					System.out.print(s+",\n");
//					return s;
//				}
//			};
//			lc.add(c);
//		}
//		List<String> res = excoutorTimeout(lc, 10);
//		res.stream().forEach(s->{
//			System.out.print(s+",\n");
//		});
//		Map<String, Callable<String>> temp = new HashMap<>();
//		for (String s : ss) {
//			Callable<String> c = new Callable<String>() {
//				@Override
//				public String call() throws Exception {
//					System.out.print(s+",,\n");
//					return s;
//				}
//			};
//			temp.put(s,c);
//		}
//		Map<String, String> res2 = excoutorTimeout(temp, 10);
//		res2.keySet().stream().forEach(s->{
//			System.out.print(s+",,\n");
//		});
//		Map<String, String> res3 = excoutorTimeout(temp, 10,23);
//		res2.keySet().stream().forEach(s->{
//			System.out.print(s+",,\n");
//		});
//	}


}
