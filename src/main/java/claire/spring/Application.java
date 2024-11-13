package claire.spring;

import ch.qos.logback.core.net.SyslogOutputStream;
import claire.spring.domain.dtos.HomeDto;
import claire.spring.domain.dtos.UserDto;
import claire.spring.domain.enums.MissionStatus;
import claire.spring.service.HomeService.HomeQueryService;
import claire.spring.service.MissionService.MissionQueryService;
import claire.spring.service.ReviewService.ReviewQueryService;
import claire.spring.service.StoreService.StoreQueryService;
import claire.spring.service.UserService.UserQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			/*
			// StoreQueryService 실행
			StoreQueryService storeService = context.getBean(StoreQueryService.class);

			// 파라미터 값 설정
			String name = "요아정";
			Float rating = 4.0f;

			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findStoresByNameAndRating with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Rating: " + rating);

			storeService.findStoresByNameAndScore(name, rating)
					.forEach(System.out::println);

			// MissionQueryService 실행
			MissionQueryService missionService = context.getBean(MissionQueryService.class);
			Long userId = 1L;
			MissionStatus status = MissionStatus.COMPLETE;
			int offset = 0;
			int limit = 10;

			System.out.println("Executing findMissionsByUserIdAndStatus with parameters:");
			System.out.println("UserId: " + userId);
			System.out.println("Status: " + status);

			missionService.getMissionByUserIdAndStatus(userId, status, offset, limit)
					.forEach(System.out::println);


			// ReviewQueryService 실행
			ReviewQueryService reviewService = context.getBean(ReviewQueryService.class);
			Long userId = 1L;
			Long missionId = 3L;
			Float rating = 4.7f;
			String title = "추천합니당";
			String content = "맛있어요! 정말 최고예요!";
			String imgUrl = "http://example.com/image.jpg";

			reviewService.insertReview(userId, missionId, rating, title, content, imgUrl);
			System.out.println("Review added successfully!");

			// HomeQueryService 실행
			HomeQueryService homeService = context.getBean(HomeQueryService.class);
			Long userId = 1L;
			Long regionId = 2L;
			int offset = 0;
			int limit = 15;

			HomeDto homeInfo = homeService.getHomeInfo(userId, regionId, offset, limit);
			System.out.println("User Points: " + homeInfo.getUserPoints());
			System.out.println("User Name: " + homeInfo.getUserName());
			System.out.println("Region Name: " + homeInfo.getRegionName());

			System.out.println("Available Missions:");
			homeInfo.getMissions().forEach(mission -> {
				System.out.println("Store Name: " + mission.getStoreName());
				System.out.println("Category Name: " + mission.getCategoryName());
				System.out.println("Mission Content: " + mission.getMissionContent());
				System.out.println("Point: " + mission.getMissionPoints());
				System.out.println("Deadline: " + mission.getDeadline());
				System.out.println("----------");
			});
			*/
			// UserQueryService 실행
			UserQueryService userService = context.getBean(UserQueryService.class);
			Long userId = 1L;

			UserDto userInfo = userService.getUserInfo(userId);
			System.out.println("User Name: " + userInfo.getName());
			System.out.println("User Nickname: " + userInfo.getNickname());
			System.out.println("User Email: " + userInfo.getEmail());
			System.out.println("address: " + userInfo.getAddress());
			System.out.println("phone_num: " + userInfo.getPhoneNum());
			System.out.println("User point: " + userInfo.getPoint());
			System.out.println("----------");
		};
	}
}
