
package de.as.roadRunners.web.journies;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;


@RestController
public class NonBlockingService {

    @RequestMapping("/nonBlocking")
    public DeferredResult<String> index(){
        DeferredResult<String> result = new DeferredResult<String>();
        
        
//        Timer timer = new Timer();
        TimerTask task = new TimeService(result);
        task.run();
//        timer.schedule(task, 4000);
        
        return result;
    }
    
    
    public static class TimeService extends TimerTask {
        private final DeferredResult<String> result;

        private TimeService(DeferredResult<String> result) {
            this.result = result;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(4000l);
                result.setResult(new Date().toString());
            } catch (InterruptedException ex) {
                Logger.getLogger(NonBlockingService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
