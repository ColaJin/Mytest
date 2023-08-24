package hikversion;

/**
 * @author:jinyandong
 * @description:存储指令头信息
 * @Date:2023/7/15
 */
public interface InstructionInfo {
    /**
     * 帧头
     */
    final byte header = 0x02;
    /**
     * 目标地址0位
     */
    final byte des0 = 0x30;
    /**
     * 目标地址1位
     */
    final byte des1 = 0x30;
    /**
     * 源地址0位
     */
    final byte src0 = 0x30;
    /**
     * 源标地址1位
     */
    final byte src1 = 0x31;
    /**
     * 帧尾
     */
    final byte tail = 0x03;
}
