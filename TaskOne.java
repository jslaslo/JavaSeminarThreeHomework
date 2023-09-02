import netscape.javascript.JSObject;

public class TaskOne {
    public static void main(String[] args) {
        String QUERY = "select * from students where ";
        String PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        StringBuilder sb = new StringBuilder();

        sb = answer(QUERY, PARAMS);
        System.out.println(sb);
    }

    public static StringBuilder answer(String QUERY, String PARAMS) {
        PARAMS = PARAMS.replace("}", "").replace("{", "");

        String[] paramsArray = PARAMS.split(",");
        StringBuilder sb = new StringBuilder();
        sb.append(QUERY);

        for (int i = 0; i < paramsArray.length; i++) {
            String[] blockArray = paramsArray[i].split(":");
            for (int j = 0; j < blockArray.length; j++) {
                if (!paramsArray[i].contains("null")) {
                    blockArray[j] = blockArray[j].replace(" ", "");
                    if (i == 0) {
                        if (j == 0) {
                            blockArray[j] = blockArray[j].replace("\"", "");
                            sb.append(blockArray[j] + "=");
                        }
                        else {
                            blockArray[j] = blockArray[j].replace("\"", "\'");
                            sb.append(blockArray[j]);
                        }
                    }
                    else {
                        if (j == 0) {
                            blockArray[j] = blockArray[j].replace("\"", "");
                            blockArray[j] = " and " + blockArray[j];
                            sb.append(blockArray[j] + "=");
                        } else {
                            blockArray[j] = blockArray[j].replace("\"", "\'");
                            sb.append(blockArray[j]);
                        }
                    }
                }

            }
        }
        return sb;
    }
}
