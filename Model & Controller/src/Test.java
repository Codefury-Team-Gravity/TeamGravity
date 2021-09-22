import com.hsbc.dao.UserDao;
import com.hsbc.dao.UserDaoFactory;
import com.hsbc.exceptions.NoUserFoundException;
import com.hsbc.exceptions.UserAlreadyPresentException;
import com.hsbc.pojo.Credential;
import com.hsbc.pojo.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u=new User(1,"sai","user","8783748374","fdjsbj","sai");
		Credential c=new Credential("sai","123");
		UserDao ud=UserDaoFactory.getUserDoaObject();
		try {
			int k=ud.addUser(u, c);
			//User u1=ud.getUserById(1);
			//User u2=ud.getUserByUserName("sai");
			System.out.println(k);
		} catch (UserAlreadyPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
