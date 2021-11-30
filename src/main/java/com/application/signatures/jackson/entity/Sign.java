package com.application.signatures.jackson.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sign {
    private String login;
    private Boolean sign;

    @Override
    public String toString() {
        return login;
    }
}
