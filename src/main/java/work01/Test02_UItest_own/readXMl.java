package work01.Test02_UItest_own;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.xiaoyun.uiframework.Locator;
import com.xiaoyun.uiframework.Locator.ByType;
import com.xiaoyun.utils.xmlUtil;






//使用dom4j工具包取xml数据的测试类
public class readXMl {

	public static void main(String[] args) throws DocumentException {

		HashMap<String,Locator> ls = xmlUtil.readElementInfo("LoginPage.xml");
		System.out.println(ls.get("login").getElementName());
	}
		
	}



