// LC: 1784. Check if Binary String Has at Most One Segment of Ones (POTD-6 MARCH 2026)
// CONTIGOUS 1's (adjacent 1's); only max one segment allowed


// easy trick: check if string contains "01" or not

class Solution {
    public boolean checkOnesSegment(String s) {
        boolean zeroseen=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0'){
                zeroseen = true;
            }
            else if(zeroseen){
                return false;
            }
        }
        return true;
    }
}




// one liner
// class Solution {
//     public boolean checkOnesSegment(String s) {
//         return !s.contains("01");
//     }
// }