/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahoa;

/**
 *
 * @author hesac
 */
public class MaHoa {

    public static String maHoaThayThe(String pl) {
        pl = pl.toLowerCase();
        String[] B = new String[5];
        B[0] = "abcdefghijklmnopqrstuvwxyz";
        B[1] = "defghijklmnopqrstuvwxyzabc";
        B[2] = "ghijklmnopqrstuvwxyzabcdef";
        B[3] = "jklmnopqrstuvwxyzabcdefghi";
        B[4] = "mnopqrstuvwxyzabcdefghijkl";

        String temp = new String();
        for (int i = 0; i < pl.length(); i++) {
            temp += (String.valueOf(B[i % 4 + 1].charAt(B[0].indexOf(pl.charAt(i)))));

        }
        return temp;
    }

    public static String maHoaHoanVi(String pl) {
        int[] Key = new int[8];
        Key[3] = 0;
        Key[7] = 1;
        Key[0] = 2;
        Key[4] = 3;
        Key[6] = 4;
        Key[1] = 5;
        Key[5] = 6;
        Key[2] = 7;
        String temp = new String(pl);
        String temp2 = new String();

        if (pl.length() % 8 != 0) {
            for (int i = 0; i < (8 - (pl.length() % 8)); i++) {
                temp += " ";
            }
        }
        pl = "";
        for (int i = 0; i < temp.length() / 8; i++) {
            temp2 = temp.substring(i * 8, i * 8 + 8);
            String temp3 = "";
            for (int j = i * 8; j < i * 8 + 8; j++) {

                temp3 += temp2.charAt(7 - Key[7 - j % 8]);
            }
            pl += temp3;
        }
        return pl;
    }

    public static String maHoaXOR(String pl, char key) {
        String binkey = '0' + Integer.toBinaryString((int) key);
        String binstr = new String();
        for (int i = 0; i < pl.length(); i++) {
            binstr += '0';
            binstr += Integer.toBinaryString((int) pl.charAt(i));
        }
        String rs = new String();
        for (int i = 0; i < binstr.length(); i++) {
            if (binkey.charAt(i % 8) == binstr.charAt(i)) {
                rs += '0';
            } else {
                rs += 1;
            }
        }
        return rs;
    }

    public static String maHoaVeman(String pl, String key) {
        pl = pl.toLowerCase();
        key = key.toLowerCase();
        String ap = "abcdefghijklmnopqrstuvwxyz";
        String rs = new String();

        for (int i = 0; i < pl.length(); i++) {
            int t = ap.indexOf(pl.charAt(i)) + ap.indexOf(key.charAt(i)) > 25 ? 
                    (ap.indexOf(pl.charAt(i)) + ap.indexOf(key.charAt(i)) - 25) 
                    : ap.indexOf(pl.charAt(i)) + ap.indexOf(key.charAt(i));
            rs += ap.charAt(t + 1);
        }
        return rs;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ma hoa thay the chuoi \"sackgaulsparenoone\" : " + maHoaThayThe("sackgaulsparenoone"));
        System.out.println("Ma hoa hoan vi chuoi \"sackgaulsparenoone\"  : " + maHoaHoanVi("sackgaulsparenoone"));
        System.out.println("Ma hoa XOR chuoi \"CAT\" voi khoa \'V\' : " + maHoaXOR("CAT",'V'));
        System.out.println("Ma hoa Veman chuoi \"sackgaulsparenoone\" voi one-time pad \"fpqrnsbiehtzlacdgj\" : " + maHoaVeman("sackgaulsparenoone", "fpqrnsbiehtzlacdgj"));

    }
}
