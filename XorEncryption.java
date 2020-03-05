
public class XorEncryption extends MiniJava {

  public static void main(String[] args) {
    int key = read("Please enter a key between 0 and 63:");
    while (key < 0 || key > 63)
      key = read("Wrong input");
    int cbc_initial = read("Please enter an initialization vector between 0 and 63:");
    while (cbc_initial < 0 || cbc_initial > 63)
      cbc_initial = read("Wrong input");

    String s = readString("Please enter the plaintext:");

    int n = s.length();

    int[] textArray = new int[n];
    int i = 0;
    while (i < n) {
      if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
        textArray[i] = s.charAt(i) - 'a';
      else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
        textArray[i] = s.charAt(i) - 'A' + 26;
      else if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
        textArray[i] = s.charAt(i) - '0' + 2 * 26;
      else if (s.charAt(i) == ' ')
        textArray[i] = 62;
      else if (s.charAt(i) == '.')
        textArray[i] = 63;
      else {
        write("Invalid character");
        return;
      }
      i++;
    }

    // Encryption
    i = 0;
    while (i < n) {
      int cbc;
      if (i == 0)
        cbc = cbc_initial;
      else
        cbc = textArray[i - 1];
      textArray[i] = textArray[i] ^ cbc ^ key;
      i++;
    }

    String result = "";
    i = 0;
    while (i < n) {
      if (textArray[i] < 26)
        result += "" + (char) ('a' + textArray[i]);
      else if (textArray[i] < 2 * 26)
        result += "" + (char) ('A' + textArray[i] - 26);
      else if (textArray[i] < 2 * 26 + 10)
        result += "" + (char) ('0' + textArray[i] - 2 * 26);
      else if (textArray[i] == 62)
        result += ' ';
      else if (textArray[i] == 63)
        result += '.';
      i++;
    }
    write(result);

    // Decryption
    i = n - 1;
    while (i >= 0) {
      int cbc;
      if (i == 0)
        cbc = cbc_initial;
      else
        cbc = textArray[i - 1];
      textArray[i] = textArray[i] ^ cbc ^ key;
      i--;
    }

    result = "";
    i = 0;
    while (i < n) {
      if (textArray[i] < 26)
        result += "" + (char) ('a' + textArray[i]);
      else if (textArray[i] < 2 * 26)
        result += "" + (char) ('A' + textArray[i] - 26);
      else if (textArray[i] < 2 * 26 + 10)
        result += "" + (char) ('0' + textArray[i] - 2 * 26);
      else if (textArray[i] == 62)
        result += ' ';
      else if (textArray[i] == 63)
        result += '.';
      i++;
    }
    write(result);
  }
}

