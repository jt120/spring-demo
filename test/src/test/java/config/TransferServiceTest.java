package config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
   classes = {
       TransferServiceConfig.class,
       StandaloneDataConfig.class,
//       JndiDataConfig.class
   })
@ActiveProfiles("dev")
public class TransferServiceTest {

   @Autowired
   private TransferService transferService;

   @Test
   public void testTransferService() {
       // test the transferService
   }
}