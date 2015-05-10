package lianxi;

import java.util.ArrayList;
import java.util.List;

import bean.user;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class lianxi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
JSONObject object =new JSONObject();
List<user> l=new ArrayList<user>();
user u=new user();
u.setId(111);
u.setPassword("222");
u.setType("eee");
l.add(u);
object.put("total", 1);
object.put("rows", l);
String result=object.toString();//jsonobject-->string

JSONObject o1=JSONObject.fromObject(result);//String-->jsonobject
JSONArray l1= (JSONArray) o1.get("rows");//获取jsonarray
user[] users=(user[]) JSONArray.toArray(l1,user.class);//获取bean
for(user t:users)
System.out.print(t.getPassword());
	}

}
