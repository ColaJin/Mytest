package reflect;

public class TestClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器--->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器---->根加载器
        System.out.println(parent.getParent());


        //获取当前类的加载器
        System.out.println(Class.forName("reflect.TestClassLoader").getClassLoader());

        //测试JDK内置的类是谁加载的
        System.out.println(Class.forName("java.lang.Object").getClassLoader());

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        //双亲委派机制
        //不可以自定义一个java.lang.String的类

        /**
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\charsets.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\deploy.jar;

         C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\access-bridge-64.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\cldrdata.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\dnsns.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jaccess.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\jfxrt.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\localedata.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\nashorn.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunec.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunjce_provider.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunmscapi.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\sunpkcs11.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\ext\zipfs.jar;

         C:\Program Files\Java\jdk1.8.0_112\jre\lib\javaws.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\jce.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfr.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\jfxswt.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\jsse.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\management-agent.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\plugin.jar;
         C:\Program Files\Java\jdk1.8.0_112\jre\lib\resources.jar;

         C:\Program Files\Java\jdk1.8.0_112\jre\lib\rt.jar;

         D:\idea_workplace\Mytest\blankProgram\target\classes;
         D:\apache-maven-3.2.5\repo\com\fasterxml\jackson\core\jackson-databind\2.5.3\jackson-databind-2.5.3.jar;
         D:\apache-maven-3.2.5\repo\com\fasterxml\jackson\core\jackson-annotations\2.5.0\jackson-annotations-2.5.0.jar;
         D:\apache-maven-3.2.5\repo\com\fasterxml\jackson\core\jackson-core\2.5.3\jackson-core-2.5.3.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\data\spring-data-jpa\2.3.1.RELEASE\spring-data-jpa-2.3.1.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\data\spring-data-commons\2.3.1.RELEASE\spring-data-commons-2.3.1.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\spring-orm\5.2.7.RELEASE\spring-orm-5.2.7.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\spring-context\5.2.7.RELEASE\spring-context-5.2.7.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\spring-aop\5.2.7.RELEASE\spring-aop-5.2.7.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\spring-tx\5.2.7.RELEASE\spring-tx-5.2.7.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\spring-beans\5.2.7.RELEASE\spring-beans-5.2.7.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\spring-core\5.2.7.RELEASE\spring-core-5.2.7.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\spring-jcl\5.2.7.RELEASE\spring-jcl-5.2.7.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\aspectj\aspectjrt\1.9.5\aspectjrt-1.9.5.jar;
         D:\apache-maven-3.2.5\repo\org\slf4j\slf4j-api\1.7.26\slf4j-api-1.7.26.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\spring-webmvc\5.2.7.RELEASE\spring-webmvc-5.2.7.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\spring-expression\5.2.7.RELEASE\spring-expression-5.2.7.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\spring-web\5.2.7.RELEASE\spring-web-5.2.7.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\hibernate\javax\persistence\hibernate-jpa-2.1-api\1.0.2.Final\hibernate-jpa-2.1-api-1.0.2.Final.jar;
         D:\apache-maven-3.2.5\repo\com\pig4cloud\excel\excel-spring-boot-starter\0.0.2\excel-spring-boot-starter-0.0.2.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\boot\spring-boot-starter-aop\2.2.6.RELEASE\spring-boot-starter-aop-2.2.6.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\aspectj\aspectjweaver\1.9.5\aspectjweaver-1.9.5.jar;
         D:\apache-maven-3.2.5\repo\com\alibaba\easyexcel\2.1.6\easyexcel-2.1.6.jar;
         D:\apache-maven-3.2.5\repo\org\apache\poi\poi\3.17\poi-3.17.jar;
         D:\apache-maven-3.2.5\repo\commons-codec\commons-codec\1.10\commons-codec-1.10.jar;
         D:\apache-maven-3.2.5\repo\org\apache\commons\commons-collections4\4.1\commons-collections4-4.1.jar;
         D:\apache-maven-3.2.5\repo\org\apache\poi\poi-ooxml\3.17\poi-ooxml-3.17.jar;
         D:\apache-maven-3.2.5\repo\org\apache\poi\poi-ooxml-schemas\3.17\poi-ooxml-schemas-3.17.jar;
         D:\apache-maven-3.2.5\repo\org\apache\xmlbeans\xmlbeans\2.6.0\xmlbeans-2.6.0.jar;
         D:\apache-maven-3.2.5\repo\stax\stax-api\1.0.1\stax-api-1.0.1.jar;
         D:\apache-maven-3.2.5\repo\com\github\virtuald\curvesapi\1.04\curvesapi-1.04.jar;
         D:\apache-maven-3.2.5\repo\cglib\cglib\3.1\cglib-3.1.jar;
         D:\apache-maven-3.2.5\repo\org\ow2\asm\asm\4.2\asm-4.2.jar;
         D:\apache-maven-3.2.5\repo\org\ehcache\ehcache\3.7.1\ehcache-3.7.1.jar;
         D:\apache-maven-3.2.5\repo\org\glassfish\jaxb\jaxb-runtime\2.3.1\jaxb-runtime-2.3.1.jar;
         D:\apache-maven-3.2.5\repo\javax\xml\bind\jaxb-api\2.3.1\jaxb-api-2.3.1.jar;
         D:\apache-maven-3.2.5\repo\org\glassfish\jaxb\txw2\2.3.1\txw2-2.3.1.jar;
         D:\apache-maven-3.2.5\repo\com\sun\istack\istack-commons-runtime\3.0.7\istack-commons-runtime-3.0.7.jar;
         D:\apache-maven-3.2.5\repo\org\jvnet\staxex\stax-ex\1.8\stax-ex-1.8.jar;
         D:\apache-maven-3.2.5\repo\com\sun\xml\fastinfoset\FastInfoset\1.2.15\FastInfoset-1.2.15.jar;
         D:\apache-maven-3.2.5\repo\javax\activation\javax.activation-api\1.2.0\javax.activation-api-1.2.0.jar;
         D:\apache-maven-3.2.5\repo\mysql\mysql-connector-java\5.1.4\mysql-connector-java-5.1.4.jar;
         D:\apache-maven-3.2.5\repo\org\activiti\activiti-engine\7.1.0.M6\activiti-engine-7.1.0.M6.jar;
         D:\apache-maven-3.2.5\repo\org\activiti\api\activiti-api-runtime-shared\7.1.0.M6\activiti-api-runtime-shared-7.1.0.M6.jar;
         D:\apache-maven-3.2.5\repo\org\activiti\core\common\activiti-project-model\7.1.0.M6\activiti-project-model-7.1.0.M6.jar;
         D:\apache-maven-3.2.5\repo\org\activiti\activiti-bpmn-converter\7.1.0.M6\activiti-bpmn-converter-7.1.0.M6.jar;
         D:\apache-maven-3.2.5\repo\org\activiti\activiti-bpmn-model\7.1.0.M6\activiti-bpmn-model-7.1.0.M6.jar;
         D:\apache-maven-3.2.5\repo\org\activiti\activiti-process-validation\7.1.0.M6\activiti-process-validation-7.1.0.M6.jar;
         D:\apache-maven-3.2.5\repo\org\apache\commons\commons-email\1.5\commons-email-1.5.jar;
         D:\apache-maven-3.2.5\repo\com\sun\mail\javax.mail\1.5.6\javax.mail-1.5.6.jar;
         D:\apache-maven-3.2.5\repo\javax\activation\activation\1.1\activation-1.1.jar;
         D:\apache-maven-3.2.5\repo\org\apache\commons\commons-lang3\3.8.1\commons-lang3-3.8.1.jar;
         D:\apache-maven-3.2.5\repo\org\mybatis\mybatis\3.5.0\mybatis-3.5.0.jar;
         D:\apache-maven-3.2.5\repo\de\odysseus\juel\juel-api\2.2.7\juel-api-2.2.7.jar;
         D:\apache-maven-3.2.5\repo\de\odysseus\juel\juel-impl\2.2.7\juel-impl-2.2.7.jar;
         D:\apache-maven-3.2.5\repo\de\odysseus\juel\juel-spi\2.2.7\juel-spi-2.2.7.jar;
         D:\apache-maven-3.2.5\repo\joda-time\joda-time\2.10.5\joda-time-2.10.5.jar;
         D:\apache-maven-3.2.5\repo\org\slf4j\jcl-over-slf4j\1.7.30\jcl-over-slf4j-1.7.30.jar;
         D:\apache-maven-3.2.5\repo\commons-io\commons-io\2.6\commons-io-2.6.jar;
         D:\apache-maven-3.2.5\repo\org\activiti\activiti-spring\7.1.0.M6\activiti-spring-7.1.0.M6.jar;
         D:\apache-maven-3.2.5\repo\org\activiti\core\common\activiti-spring-project\7.1.0.M6\activiti-spring-project-7.1.0.M6.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\spring-jdbc\5.1.13.RELEASE\spring-jdbc-5.1.13.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\javax\el\el-api\2.2\el-api-2.2.jar;
         D:\apache-maven-3.2.5\repo\org\activiti\api\activiti-api-model-shared\7.1.0.M6\activiti-api-model-shared-7.1.0.M6.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\security\spring-security-core\5.1.6.RELEASE\spring-security-core-5.1.6.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\security\spring-security-config\5.1.6.RELEASE\spring-security-config-5.1.6.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\boot\spring-boot-starter-web\2.3.4.RELEASE\spring-boot-starter-web-2.3.4.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\boot\spring-boot-starter\2.3.4.RELEASE\spring-boot-starter-2.3.4.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\boot\spring-boot\2.3.4.RELEASE\spring-boot-2.3.4.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\boot\spring-boot-autoconfigure\2.3.4.RELEASE\spring-boot-autoconfigure-2.3.4.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\boot\spring-boot-starter-logging\2.3.4.RELEASE\spring-boot-starter-logging-2.3.4.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;
         D:\apache-maven-3.2.5\repo\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;
         D:\apache-maven-3.2.5\repo\org\apache\logging\log4j\log4j-to-slf4j\2.13.3\log4j-to-slf4j-2.13.3.jar;
         D:\apache-maven-3.2.5\repo\org\apache\logging\log4j\log4j-api\2.13.3\log4j-api-2.13.3.jar;
         D:\apache-maven-3.2.5\repo\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar;
         D:\apache-maven-3.2.5\repo\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;
         D:\apache-maven-3.2.5\repo\org\yaml\snakeyaml\1.26\snakeyaml-1.26.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\boot\spring-boot-starter-json\2.3.4.RELEASE\spring-boot-starter-json-2.3.4.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.11.2\jackson-datatype-jdk8-2.11.2.jar;
         D:\apache-maven-3.2.5\repo\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.11.2\jackson-datatype-jsr310-2.11.2.jar;
         D:\apache-maven-3.2.5\repo\com\fasterxml\jackson\module\jackson-module-parameter-names\2.11.2\jackson-module-parameter-names-2.11.2.jar;
         D:\apache-maven-3.2.5\repo\org\springframework\boot\spring-boot-starter-tomcat\2.3.4.RELEASE\spring-boot-starter-tomcat-2.3.4.RELEASE.jar;
         D:\apache-maven-3.2.5\repo\org\apache\tomcat\embed\tomcat-embed-core\9.0.38\tomcat-embed-core-9.0.38.jar;
         D:\apache-maven-3.2.5\repo\org\glassfish\jakarta.el\3.0.3\jakarta.el-3.0.3.jar;
         D:\apache-maven-3.2.5\repo\org\apache\tomcat\embed\tomcat-embed-websocket\9.0.38\tomcat-embed-websocket-9.0.38.jar;

         C:\Program Files\JetBrains\IntelliJ IDEA 2019.1\lib\idea_rt.jar
         */
    }
}
