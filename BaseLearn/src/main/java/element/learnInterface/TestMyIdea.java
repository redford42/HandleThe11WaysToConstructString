package element.learnInterface;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Hanz
 * @date 2020/1/8
 */
public class TestMyIdea {
    public static void main(String[] args) {
        RemoteControl remoteControl1 = new RemoteControl();
        RemoteControl remoteControl2 = new RemoteControl();
        VolumeConfig volumeConfig = new VolumeConfig();
        remoteControl1.setCfgValue(volumeConfig);
        JSONObject jsonObject = new JSONObject();
    }
}
