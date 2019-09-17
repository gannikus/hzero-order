package org.hzero.hand.hzeroorder.api.DTO;

import org.hzero.hand.hzeroorder.domain.entity.PurHeader;
import org.hzero.hand.hzeroorder.domain.entity.PurLine;

import java.util.List;

/**
 * 采购订单dto
 *
 * @author gzm 2019/08/26 20:03
 */

public class OrderDTO {

    private  PurHeader purHeader;
    private List<PurLine> purLineList;

    public PurHeader getPurHeader() {
        return purHeader;
    }

    public void setPurHeader(PurHeader purHeader) {
        this.purHeader = purHeader;
    }

    public List<PurLine> getPurLineList() {
        return purLineList;
    }

    public void setPurLineList(List<PurLine> purLineList) {
        this.purLineList = purLineList;
    }
}
