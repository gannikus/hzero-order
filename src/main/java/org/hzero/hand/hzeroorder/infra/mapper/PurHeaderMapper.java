package org.hzero.hand.hzeroorder.infra.mapper;

import org.apache.ibatis.annotations.Param;
import org.hzero.hand.hzeroorder.domain.entity.PurHeader;
import io.choerodon.mybatis.common.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 采购订单头表Mapper
 *
 * @author gzm 2019-08-26 14:32:24
 */
@Repository
public interface PurHeaderMapper extends BaseMapper<PurHeader> {

    /**
     * 模糊查询
     * @param purHeader
     * @return
     */
    List<PurHeader> selectLike(PurHeader purHeader);
}
