package fshare.tech.transaction.service;

import fshare.tech.transaction.mapper.ClassMapper;
import fshare.tech.transaction.mapper.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author: XiaoYe
 * @create: 2024-10-02 16:23
 * @description: TODO
 */
@Service
public class DemoService {
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private ClassMapper classMapper;

    /**
     * 事务传播机制测试
     */



//    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void propagationRequired1() {
        studentMapper.updateStudentName("xiaoye", 2);
        propagationRequired2();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void propagationRequired2() {
        studentMapper.updateStudentName("小美", 3);
        throw new RuntimeException("REQUIRED rollback error!");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void propagationRequiredNew1() {
        studentMapper.updateStudentName("xiaoye", 2);
        propagationRequiredNew2();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void propagationRequiredNew2() {
        studentMapper.updateStudentName("小美", 3);
        throw new RuntimeException("REQUIRES_NEW rollback error!");
    }

    @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    public void propagationNested1() {
        studentMapper.updateStudentName("xiaoye", 2);
        propagationNested2();
    }

    @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    public void propagationNested2() {
        studentMapper.updateStudentName("小美", 3);
        throw new RuntimeException("NESTED rollback error!");
    }


    /**
     * 事务回滚测试
     * <p>
     * 测试结果
     * 回滚
     */
    @Transactional(rollbackFor = Exception.class)
    public void rollback1(String username, Integer id) throws Exception {
//        studentMapper.updateStudentName(username, id);
        throw new Exception("rollback");
    }

    /**
     * 测试结果
     * 不回滚
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void rollback2(String username, Integer id) throws Exception {
//        studentMapper.updateStudentName(username, id);
        throw new Exception("rollback");
    }

    /**
     * 测试结果
     * 不回滚
     */
    @Transactional(noRollbackFor = Exception.class)
    public void noRollback1(String username, Integer id) {
//        studentMapper.updateStudentName(username, id);
        throw new RuntimeException("rollback");
    }

    /**
     * 测试结果
     * 不回滚
     */
    @Transactional(noRollbackFor = RuntimeException.class)
    public void noRollback2(String username, Integer id) {
//        studentMapper.updateStudentName(username, id);
        throw new RuntimeException("rollback");
    }
}
