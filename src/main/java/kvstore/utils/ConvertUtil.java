package kvstore.utils;

import com.alibaba.fastjson.JSONObject;
import kvstore.model.command.Command;
import kvstore.model.command.CommandTypeEnum;
import kvstore.model.command.RmCommand;
import kvstore.model.command.SetCommand;

public class ConvertUtil {

    public static final String TYPE = "type";


    public static Command jsonToCommand(JSONObject value) {
        if (value.getString(TYPE).equals(CommandTypeEnum.SET.name())) {
            return value.toJavaObject(SetCommand.class);
        } else if (value.getString(TYPE).equals(CommandTypeEnum.RM.name())) {
            return value.toJavaObject(RmCommand.class);
        }
        return null;
    }
}
