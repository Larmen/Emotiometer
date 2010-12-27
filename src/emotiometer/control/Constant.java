package emotiometer.control;
public class Constant 
{
	public String prodName1 = "Tron Legacy";
	public String prodName2 = "TRON LEGACY";
	public String prodName3 = "tron legacy";
	
	
	final int RESULTAT_NOTHING = 0;
	//om tweetet inte innehåller någon emoticon//
	final int RESULTAT_POSITIVE = 1;
	//den innehåller en positiv//
	final int RESULTAT_NEGATIVE = 2;
	//den innehåller en negativ//
	final int RESULTAT_BOTH = 3;
	//den innehåller båda//
	
	static String[] Positive = { ":)", ":-)", ":]", "=)", ":-D", ":D", "=D", ";-)", ";)", ":-P", ":P", ":-p", ":p", "=P", "=>", ":>", ":->", "8-)", "8)", "8D", "8-D", "8-)", };
	//arrayPositive,smile,grin,wink,tongue//
	static String[] Negative = { ":-(", ":(", ":[", "=(", ">:(", ">:-(", ">:O", ">:-O", ">:o", ">:-o", "=<", ":<", ":-<", "8-(", "8-/", "8/", "=/", ":/", ":-/", };
	//arrayNegative,frown,grumpy,upset// 
	{
		for (int i=0; i<Positive.length; i++){
		}//reads Positive String Array//
		for (int i=0; i<Negative.length; i++){
		}//reads Negative String Array//	
	}

}


