
public class MatchPattern {

	public static void main(String args[]) {
		String pattern = "*ef";
		String str1 = "ef";
		String str2 = "abxxdef";
//		System.out.println(new MatchPattern().isMatch("er", "*e***r", 0, 0));
//		System.out.println(new MatchPattern().isMatch("abcdef", "*ef", 0, 0));
//		System.out.println(new MatchPattern().isMatch("abcdef", "abcdef", 0, 0));
//		System.out.println(new MatchPattern().isMatch("abcdef", "abc*gf", 0, 0));
		System.out.println(new MatchPattern().isMatch("abcdefghijklmno", "a*c**d***e******n*k", 0, 0));
	}
	
	int match[][] = new  int[20][20];
	int count = 0;
	public int isMatch(String str, String pattern, int strPos, int patternPos) {
		if(match[strPos][patternPos] != 0){
			return match[strPos][patternPos];
		}
		System.out.println(count++);
		int sol = 0;
		//if both have no more char to match
		if(strPos> str.length()-1 && patternPos + 1 > pattern.length()){
			sol = 1;
		}

		//Last Char of Pattern is *
		else if(pattern.charAt(patternPos) == '*' && pattern.length()-1 == patternPos){
			sol = 1;
		}

		else if(strPos >= str.length()-1 && pattern.charAt(patternPos) == '*'){
			sol = isMatch(str,pattern, strPos, patternPos+1);
		}

		//If pattern ends but str still have chars
		else if(str.length() <= strPos+1 && pattern.length()-1 < patternPos){
			sol = -1;
		}

		//If both have same Char
		else if(str.charAt(strPos) == pattern.charAt(patternPos)){
			sol = isMatch(str, pattern, strPos+1, patternPos+1);
		}

		//If both char are different and in pattern it is not *
		else if(str.charAt(strPos) != pattern.charAt(patternPos) && pattern.charAt(patternPos)!='*'){
			sol = -1;
		}

		else if(pattern.charAt(patternPos) == '*'){
			sol = Math.max(isMatch(str, pattern, strPos + 1, patternPos) , isMatch(str, pattern, strPos, patternPos+1));
		}
		match[strPos][patternPos] = sol;
		return sol;
	}
}


/*
if(str.charAt(strPos) != pattern.charAt(patternPos) && pattern.charAt(patternPos) != '*') {
		return false;
		}
		if(str.substring(strPos).isEmpty() && pattern.substring(patternPos).isEmpty()) {
		return true;
		}else if(str.substring(strPos).isEmpty() && (!pattern.substring(patternPos).isEmpty())) {
		return isMatch(str, pattern, strPos, patternPos+1);
		} else if(str.charAt(strPos) != pattern.charAt(patternPos) && pattern.charAt(patternPos) == '*') {
		return isMatch(str, pattern, strPos+1, patternPos) || isMatch(str, pattern, strPos, patternPos+1);
		}else if(str.charAt(strPos) == pattern.charAt(patternPos)){
		return isMatch(str, pattern, strPos+1, patternPos+1);
		}else {
		throw new RuntimeException();
		}
		*/