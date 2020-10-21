package com.methodtest.JNZXY;

public class WebserviceRequest {

    private static final Integer PAGE_NUM = 1;
    private static final Integer PAGE_SIZE = 20;
    public static void main(String[] args) {

        String update_by_where = getRequestMessage("34324324324324fdgd", "3434343", "update by where"+"\'"+"3453"+"\'");
        System.out.println(update_by_where);

    }

    private  static String getRequestMessage(String requestId,String timestampStr,String sqlStr){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<request>");
        stringBuilder.append("<requestId value=\""+requestId+"\" />");
        stringBuilder.append("<createTime value=\""+timestampStr+"\"/>");
        stringBuilder.append("<condition value=\""+sqlStr+"\"/>");
        stringBuilder.append("<pageNum value=\""+PAGE_NUM+"\"/>");
        stringBuilder.append("<pageSize value=\""+PAGE_SIZE+"\"/>");
        stringBuilder.append("</request>");
        return stringBuilder.toString();
    }

}


