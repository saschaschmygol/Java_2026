package lr2;

public class task2 {
    public static void main(String[] args){
        System.out.println(getEncryptString("dqwrwr", 3));
    }

    public static String getEncryptString (String encryptString, int shift) {

        char[] arrayChar = encryptString.toCharArray();
        long[] arrayInt = new long [arrayChar.length];
        char[] arrayCharNew = new char[arrayChar.length];

        for (int i = 0; i < arrayChar.length; i++) {
            arrayInt[i] = arrayChar[i] + shift;
            arrayCharNew[i] = (char) arrayInt[i];
        }
        encryptString = new String(arrayCharNew);

        return encryptString;
    }
}
