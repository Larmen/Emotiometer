package emotiometer.control;
public class Constant 
{
	int RESULTAT_NOTHING = 0;
	//om tweetet inte inneh�ller n�gon emoticon//
	int RESULTAT_POSITIVE = 1;
	//den inneh�ller en positiv//
	int RESULTAT_NEGATIVE = 2;
	//den inneh�ller en negativ//
	int RESULTAT_BOTH = 3;
	//den inneh�ller b�da//
	
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
	public String prodName1 = " Tron ";
	public String prodName2 = " TRON ";
	public String prodName3 = " tron ";
}


