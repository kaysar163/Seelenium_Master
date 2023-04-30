package com.magentoapplication.ui.backend.marketingmodule;

public class TestHelperMarketing {

    private static String RuleName;
    private static String templateName;

    private static String changeTemplateName;



    private static String nickName;
    private static String changedNickName;
    public static String getChangedNickName() {
        return changedNickName;
    }

    public static void setChangedNickName(String changedNickName) {
        TestHelperMarketing.changedNickName = changedNickName;
    }



    public static String getNickName() {
        return nickName;
    }

    public static void setNickName(String nickName) {
        TestHelperMarketing.nickName = nickName;
    }


    public static String getTemplateName() {
        return templateName;
    }

    public static void setTemplateName(String templateName) {

        TestHelperMarketing.templateName = templateName;
    }

    public static String getChangeTemplateName() {
        return changeTemplateName;
    }

    public static void setChangeTemplateName(String changeTemplateName) {
        TestHelperMarketing.changeTemplateName = changeTemplateName;
    }
    public static String getRuleName() {
        return RuleName;
    }

    public static void setRuleName(String ruleName) {
        RuleName = ruleName;
    }
}


