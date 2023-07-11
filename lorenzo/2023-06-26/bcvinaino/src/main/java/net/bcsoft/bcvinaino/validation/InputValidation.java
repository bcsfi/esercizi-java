package net.bcsoft.bcvinaino.validation;

import net.bcsoft.bcvinaino.exception.DateNotValidException;
import net.bcsoft.bcvinaino.exception.IdNotValidException;

import java.sql.Date;
import java.time.LocalDate;

public class InputValidation {
    public InputValidation() {
    }

    public static Long idIsValid(Long id) {
        if (id == null) { throw new IdNotValidException("ID is null"); }
        if (id < 0) { throw new IdNotValidException("ID is negative"); }
        else {
            return id;
        }
    }

    public static Date dateIsValid(Date data) {
        Date today = Date.valueOf(LocalDate.now());
        if (data.after(today)) { throw new DateNotValidException("Grande Giove!"); }
        else {
            return data;
        }
    }
}
