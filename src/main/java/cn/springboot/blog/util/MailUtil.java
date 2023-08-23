package cn.springboot.blog.util;

public class MailUtil {
    public static String get6Code(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<6;i++){
            stringBuilder.append((int)(Math.random()*10));
        }
        return stringBuilder.toString();
    }
    public static String getHtmlContent(String code,String action,String username){
        char[] chars = code.toCharArray();
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>邮箱验证码</title>\n" +
                "    <style>\n" +
                "        table {\n" +
                "            width: 700px;\n" +
                "            margin: 0 auto;\n" +
                "        }\n" +
                "\n" +
                "        #top {\n" +
                "            width: 700px;\n" +
                "            border-bottom: 1px solid #ccc;\n" +
                "            margin: 0 auto 30px;\n" +
                "        }\n" +
                "\n" +
                "        #top table {\n" +
                "            font: 12px Tahoma, Arial, 宋体;\n" +
                "            height: 40px;\n" +
                "        }\n" +
                "\n" +
                "        #content {\n" +
                "            width: 680px;\n" +
                "            padding: 0 10px;\n" +
                "            margin: 0 auto;\n" +
                "        }\n" +
                "\n" +
                "        #content_top {\n" +
                "            line-height: 1.5;\n" +
                "            font-size: 14px;\n" +
                "            margin-bottom: 25px;\n" +
                "            color: #4d4d4d;\n" +
                "        }\n" +
                "\n" +
                "        #content_top strong {\n" +
                "            display: block;\n" +
                "            margin-bottom: 15px;\n" +
                "        }\n" +
                "\n" +
                "        #content_top strong span {\n" +
                "            color: #f60;\n" +
                "            font-size: 16px;\n" +
                "        }\n" +
                "\n" +
                "        #verificationCode {\n" +
                "            color: #f60;\n" +
                "            font-size: 24px;\n" +
                "        }\n" +
                "\n" +
                "        #content_bottom {\n" +
                "            margin-bottom: 30px;\n" +
                "        }\n" +
                "\n" +
                "        #content_bottom small {\n" +
                "            display: block;\n" +
                "            margin-bottom: 20px;\n" +
                "            font-size: 12px;\n" +
                "            color: #747474;\n" +
                "        }\n" +
                "\n" +
                "        #bottom {\n" +
                "            width: 700px;\n" +
                "            margin: 0 auto;\n" +
                "        }\n" +
                "\n" +
                "        #bottom div {\n" +
                "            padding: 10px 10px 0;\n" +
                "            border-top: 1px solid #ccc;\n" +
                "            color: #747474;\n" +
                "            margin-bottom: 20px;\n" +
                "            line-height: 1.3em;\n" +
                "            font-size: 12px;\n" +
                "        }\n" +
                "\n" +
                "        #content_top strong span {\n" +
                "            font-size: 18px;\n" +
                "            color: #FE4F70;\n" +
                "        }\n" +
                "\n" +
                "        #sign {\n" +
                "            text-align: right;\n" +
                "            font-size: 18px;\n" +
                "            color: #FE4F70;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "\n" +
                "        #verificationCode {\n" +
                "            height: 100px;\n" +
                "            width: 680px;\n" +
                "            text-align: center;\n" +
                "            margin: 30px 0;\n" +
                "        }\n" +
                "\n" +
                "        .button {\n" +
                "            color: #FE4F70;\n" +
                "            margin-left: 10px;\n" +
                "            height: 40px;\n" +
                "            width: 40px;\n" +
                "            resize: none;\n" +
                "            float: left;\n" +
                "            font-size: 30px;\n" +
                "            border: none;\n" +
                "            outline: none;\n" +
                "            padding: 10px 15px;\n" +
                "            background: #ededed;\n" +
                "            text-align: center;\n" +
                "            border-radius: 17px;\n" +
                "            box-shadow: 6px 6px 12px #cccccc,\n" +
                "            -6px -6px 12px #ffffff;\n" +
                "        }\n" +
                "\n" +
                "        .button:hover {\n" +
                "            box-shadow: inset 6px 6px 4px #d1d1d1,\n" +
                "            inset -6px -6px 4px #ffffff;\n" +
                "        }\n" +
                "\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table>\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <div id=\"top\">\n" +
                "                <table>\n" +
                "                    <tbody><tr><td></td></tr></tbody>\n" +
                "                </table>\n" +
                "            </div>\n" +
                "\n" +
                "            <div id=\"content\">\n" +
                "                <div id=\"content_top\">\n" +
                "                    <strong>尊敬的"+(username!=null?username:"用户")+"：您好！</strong>\n" +
                "                    <strong>\n" +
                "                        您正在进行<span>"+action+"</span>操作，请在验证码中输入以下验证码完成操作：\n" +
                "                    </strong>\n" +
                "                    <div id=\"verificationCode\">\n" +
                "                        <div class=\"button\">"+chars[0]+"</div>\n" +
                "                        <div class=\"button\">"+chars[1]+"</div>\n" +
                "                        <div class=\"button\">"+chars[2]+"</div>\n" +
                "                        <div class=\"button\">"+chars[3]+"</div>\n" +
                "                        <div class=\"button\">"+chars[4]+"</div>\n" +
                "                        <div class=\"button\">"+chars[5]+"</div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div id=\"content_bottom\">\n" +
                "                    <small>\n" +
                "                        注意：此操作可能会修改您的密码、登录邮箱或绑定手机。如非本人操作，请及时登录并修改密码以保证帐户安全\n" +
                "                        <br>（工作人员不会向你索取此验证码，请勿泄漏！)\n" +
                "                    </small>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div id=\"bottom\">\n" +
                "                <div>\n" +
                "                    <p>此为系统邮件，请勿回复<br>\n" +
                "                        请保管好您的邮箱，避免账号被他人盗用\n" +
                "                    </p>\n" +
                "                    <p id=\"sign\">——Romantik</p>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</body>";
    }

    public static  String getSimpleContent(String code,String action){
        return "您正在"+action+",验证码为"+code;
    }
}
