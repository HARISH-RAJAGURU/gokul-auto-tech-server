package com.gokul_auto_tech.backend_gokul_auto_tech.emailsender;

import lombok.Getter;

@Getter
public enum EmailTemplateName {

    VERIFY_EMAIL("verify_email"),

    HIGHER_OFFICIAL_VERIFY_EMAIL("higher_official_verify_email"),

    HIGHER_OFFICIAL_DECISION_ACCEPT("higher_official_decision_accept"),

    HIGHER_OFFICIAL_DECISION_REJECT("higher_official_decision_reject"),

    UPDATE_DETAILS("update_details"),

    UPDATE_ACCEPT("update_accept"),

    UPDATE_REJECT("update_reject");

    private final String templateName;

    EmailTemplateName(String templateName){
        this.templateName=templateName;
    }

}
