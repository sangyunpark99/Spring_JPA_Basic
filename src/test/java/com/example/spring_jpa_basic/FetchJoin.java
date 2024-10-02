package com.example.spring_jpa_basic;

import com.example.spring_jpa_basic.페치조인.Order;
import com.example.spring_jpa_basic.페치조인.Team;
import com.example.spring_jpa_basic.페치조인.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class FetchJoin {

    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    @Rollback(value = false)
    void 페치조인() throws Exception {

        // 팀 저장
        Team teamA = new Team("A");
        Team teamB = new Team("B");
        Team teamC = new Team("C");
        em.persist(teamA);
        em.persist(teamB);
        em.persist(teamC);

        // 회원 저장
        User user1 = new User("user1", teamA);
        User user2 = new User("user2", teamB);
        User user3 = new User("user3", teamC);
        em.persist(user1);
        em.persist(user2);
        em.persist(user3);

        em.flush();
        em.clear();

        String query = "select u from User u join fetch u.team";
        List<User> resultList = em.createQuery(query, User.class).getResultList();

        for(User user: resultList) {
            System.out.println("팀 이름 : " + user.getTeam().getName());
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void 페치_조인_alias_사용_불가() throws Exception {

        // 팀 저장
        Team teamA = new Team("A");
        Team teamB = new Team("B");
        Team teamC = new Team("C");
        em.persist(teamA);
        em.persist(teamB);
        em.persist(teamC);

        // 회원 저장
        User user1 = new User("user1", teamA);
        User user2 = new User("user2", teamB);
        User user3 = new User("user3", teamC);
        em.persist(user1);
        em.persist(user2);
        em.persist(user3);

        em.flush();
        em.clear();

        String queryA = "select u from User u join fetch u.team t where t.name = 'A'";
        String queryB = "select u from User u join fetch u.team t where t.name = 'B'";
        String queryC = "select u from User u join fetch u.team t where t.name = 'C'";
        List<User> resultA = em.createQuery(queryA, User.class).getResultList();
        List<User> resultB = em.createQuery(queryB, User.class).getResultList();
        List<User> resultC = em.createQuery(queryC, User.class).getResultList();

        System.out.println(resultA.get(0).getTeam().getName());
        System.out.println(resultB.get(0).getTeam().getName());
        System.out.println(resultC.get(0).getTeam().getName());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void 페치조인_컬렉션2개이상_조회() throws Exception {

        // 팀 저장
        Team teamA = new Team("A");
        em.persist(teamA);

        // 회원 저장
        User user1 = new User("user1", teamA);
        User user2 = new User("user2", teamA);
        em.persist(user1);
        em.persist(user2);

        // 주문 저장
        Order order1 = new Order("user1주문1", user1);
        Order order2 = new Order("user1주문2", user1);
        Order order3 = new Order("user2주문1", user2);
        em.persist(order1);
        em.persist(order2);
        em.persist(order3);

        em.flush();
        em.clear();

        String query = "select u from User u \n"
                + "join fetch u.team \n"
                + "join fetch u.orders";
        List<User> resultList = em.createQuery(query, User.class).getResultList();

        System.out.println("Result Size: " + resultList.size());

        for (User user : resultList) {
            System.out.printf("username : %s, orderSize : %d \n", user.getName(), user.getOrders().size());
            for (Order order : user.getOrders()) {
                System.out.println("Order: " + order.getName());
            }
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void 페이징_조회() throws Exception {

        // 팀 저장
        Team teamA = new Team("A");
        em.persist(teamA);

        // 회원 저장
        User user1 = new User("user1", teamA);
        User user2 = new User("user2", teamA);
        em.persist(user1);
        em.persist(user2);

        em.flush();
        em.clear();

        String query = "select t from Team t join fetch t.users";

        List<Team> resultList = em.createQuery(query, Team.class)
                .setFirstResult(0)
                .setMaxResults(1)
                .getResultList();

        System.out.println("Result Size: " + resultList.size());

        for (Team team : resultList) {
            System.out.println(team.toString());
        }
    }
}