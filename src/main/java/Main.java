import Data.HibernateUtil;
import Data.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Session session = HibernateUtil.getSession().openSession();

        List<String> user = null;

        try {
            session.beginTransaction();
            System.out.println("If your want to add date in database , enter: add");
            System.out.println("If your want to get info about user message, enter: get");
            String state = reader.readLine();
            if (state.equals("add")) {
                System.out.print("name: ");
                String name_str = reader.readLine();
                System.out.print("Message: ");
                String text_str = reader.readLine();
                Query query = session.createSQLQuery("INSERT INTO user(name,text) VALUES " +
                        "('" + name_str + "','" + text_str + "')");
                query.executeUpdate();
            } else if (state.equals("get")) {
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
                Root<UserEntity> root = criteriaQuery.from(UserEntity.class);

                System.out.print("Enter name : ");
                String s = reader.readLine();

                criteriaQuery.select(root.get("text"));
                criteriaQuery.where(builder.equal(root.get("name"), s));
                /*
                * SELECT TEXT FROM user WHERE NAME = S;
                * */
                Query<String> query = session.createQuery(criteriaQuery);
                user = query.getResultList();
                for (String userStr : user) {
                    System.out.println(userStr);
                }
            } else {
                System.exit(0);
            }
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}