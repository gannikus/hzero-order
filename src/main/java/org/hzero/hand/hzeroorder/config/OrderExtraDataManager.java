package org.hzero.hand.hzeroorder.config;

import io.choerodon.core.swagger.ChoerodonRouteData;
import io.choerodon.swagger.annotation.ChoerodonExtraData;
import io.choerodon.swagger.swagger.extra.ExtraData;
import io.choerodon.swagger.swagger.extra.ExtraDataManager;

/**
 * description
 * 服务路由配置
 * @author gzm 2019/08/09 20:03
 */
@ChoerodonExtraData
public class OrderExtraDataManager implements ExtraDataManager {
    @Override
    public ExtraData getData() {
        ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
        choerodonRouteData.setName("hodr");
        choerodonRouteData.setPath("/horder/**");
        choerodonRouteData.setServiceId("hzero-order");
        extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
        return extraData;
    }
}
