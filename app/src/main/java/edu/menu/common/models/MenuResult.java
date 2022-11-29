package edu.menu.common.models;

import edu.menu.common.interfaces.IOption;

public class MenuResult<T extends IOption> {
    public T _value = null;
    public Exception _err = null;

    public MenuResult(T value, Exception err) {
        _value = value;
        _err = err;
    }

    public Boolean isOk() {
        return _err == null && _value != null;
    }

    public Boolean isErr() {
        return _err != null && _value == null;
    }

    public T unwrap() throws Exception {
        if (isErr()) throw _err;
        return _value;
    }
}
