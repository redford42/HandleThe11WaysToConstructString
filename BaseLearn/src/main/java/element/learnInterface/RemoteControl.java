package element.learnInterface;

import lombok.Data;

/**
 * @author Hanz
 * @date 2020/1/8
 */
@Data
public class RemoteControl {
    private String deviceId;
    private String enterpriseId;
    private int state;
    private String cfgKey;
    private BaseConfig cfgValue;

}
