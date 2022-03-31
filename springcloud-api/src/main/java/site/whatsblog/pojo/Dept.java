package site.whatsblog.pojo;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <strong>
 * description : 实体类，类表关系映射
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/30 10:15</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) // 链式写法
public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    private String dbSource;

    public Dept(String dname) {
        this.dname = dname;
    }

    /*
         链式写法
         Dept dept = new Dept();
         dept.setdeptno(1).setDname();
     */
}
