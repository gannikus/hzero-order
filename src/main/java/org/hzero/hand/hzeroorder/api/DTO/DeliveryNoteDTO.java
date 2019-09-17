package org.hzero.hand.hzeroorder.api.DTO;

import org.hzero.hand.hzeroorder.domain.entity.DeliveryNoteHead;
import org.hzero.hand.hzeroorder.domain.entity.DeliveryNoteLine;

import java.util.List;

/**
 * 送货单dto
 *
 * @author gzm 2019/08/29 9:15
 */
public class DeliveryNoteDTO {

    private DeliveryNoteHead deliveryNoteHead;
    private List<DeliveryNoteLine> deliveryNoteLineList;

    public DeliveryNoteHead getDeliveryNoteHead() {
        return deliveryNoteHead;
    }

    public void setDeliveryNoteHead(DeliveryNoteHead deliveryNoteHead) {
        this.deliveryNoteHead = deliveryNoteHead;
    }

    public List<DeliveryNoteLine> getDeliveryNoteLineList() {
        return deliveryNoteLineList;
    }

    public void setDeliveryNoteLineList(List<DeliveryNoteLine> deliveryNoteLineList) {
        this.deliveryNoteLineList = deliveryNoteLineList;
    }
}
