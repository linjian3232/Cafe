package test;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.xeonwang.tmxk.domain.Food;
import top.xeonwang.tmxk.service.FoodService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/*.xml")
public class FoodServiceImplTest {
	@Autowired
    FoodService foodService;

    @Test
    public void test(){
    	List<Food> lf=foodService.GetAll();
    }

}
