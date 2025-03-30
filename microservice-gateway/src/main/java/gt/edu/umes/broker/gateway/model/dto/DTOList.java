package gt.edu.umes.broker.gateway.model.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class DTOList extends ArrayList<Objects> {
    public DTOList() { }
    public DTOList(Collection<? extends Objects> c) {
        super(c);
    }
}
