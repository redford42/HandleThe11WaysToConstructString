package element.stream;

import com.google.common.collect.Lists;
import element.stream.model.Human;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Hanz
 * @date 2018/12/27
 */

public class ListLambda {
    @Test
    public void whenSortingEntitiesByNameThenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        humans.sort(
                Comparator.comparing(Human::getName));

        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }


}
