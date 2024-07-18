package ge.bog.nnagliashvilifinalproject.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggingAspect {

    // Define a pointcut that matches all methods in com.example.assignment2project package and its sub-packages
    @Pointcut("execution(* ge.bog.nnagliashvilifinalproject..*(..))")
    public void applicationPackagePointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advice.
    }

    // Around advice to log method entry, arguments, and exit
    @Around("applicationPackagePointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Method '{}' called with arguments:", methodName);

        for (int i = 0; i < args.length; i++) {
            log.info("Arg {}: {}", i, args[i]);
        }

        Object result = joinPoint.proceed();
        log.info("Method '{}' returned with result: {}", methodName, result);
        return result;
    }

    // Before advice to log method call
    @Before("applicationPackagePointcut()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        log.info("Entering method: {}.{}()", className, methodName);
    }

    // After advice to log method completion
    @After("applicationPackagePointcut()")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        log.info("Exiting method: {}.{}()", className, methodName);
    }
}
