package ca.q0r.msocial.types;

import ca.q0r.msocial.configs.ConfigUtil;
import com.miraclem4n.mchat.util.MessageUtil;

import java.util.ArrayList;

public enum ConfigType {
    OPTION_SPOUT("option.spoutPM"),

    ALIASES_SAY("aliases.mchatsay"),
    ALIASES_PM("aliases.pmchat"),
    ALIASES_PM_REPLY("aliases.pmchatreply"),
    ALIASES_PM_INVITE("aliases.pmchatinvite"),
    ALIASES_PM_ACCEPT("aliases.pmchataccept"),
    ALIASES_PM_DENY("aliases.pmchatdeny"),
    ALIASES_PM_LEAVE("aliases.pmchatleave"),
    ALIASES_SHOUT("aliases.mchatshout"),
    ALIASES_MUTE("aliases.mchatmute");

    private final String option;

    ConfigType(String option) {
        this.option = option;
    }

    private Object getObject() {
        Object value = ConfigUtil.getConfig().get(option);

        if (value instanceof String) {
            String val = (String) value;

            value = MessageUtil.addColour(val);
        }

        return value;
    }

    public Boolean getBoolean() {
        Object object = getObject();

        return object instanceof Boolean ? (Boolean) object : false;
    }

    public String getString() {
        Object object = getObject();

        return object != null ? object.toString() : "";
    }

    public Integer getInteger() {
        Object object = getObject();

        return object instanceof Number ? (Integer) object : 0;
    }

    public Double getDouble() {
        Object object = getObject();

        return object instanceof Number ? (Double) object : 0.0;
    }

    public ArrayList<String> getList() {
        Object object = getObject();
        ArrayList<String> list = new ArrayList<String>();

        if (object instanceof ArrayList) {
            ArrayList aList = (ArrayList) object;

            for (Object obj : aList)
                list.add((String) obj);

        }

        return list;
    }
}
