package springAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
    private final IndexDao indexDao;

    public IndexService(IndexDao indexDao) {
        this.indexDao = indexDao;
    }

    public void service() {
        System.out.println(indexDao.hashCode());
        System.out.println(this.hashCode());
    }

}
