package edu.menu.common.models.options;

import edu.menu.common.interfaces.IOption;

public class StringOption implements IOption {
    private String m_value;

    public StringOption(String value) {
        m_value = value;
    }

    public static StringOption fromStr(String value) {
        return new StringOption(value);
    }

    @Override
    public String getDisplayValue() {
        return m_value.trim();
    }

}
