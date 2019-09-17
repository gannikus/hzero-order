package org.hzero.hand.hzeroorder.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import org.hzero.hand.hzeroorder.api.DTO.DlyNoteDisplayDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description
 *
 * @author gzm 2019/08/28 11:03
 */

@Repository
public interface DlyNoteDisplayDTOMapper extends BaseMapper<DlyNoteDisplayDTO> {

   /**
    * 创建送货单dto显示
    * @param dlyNoteDisplayDTO
    * @return
    */
   List<DlyNoteDisplayDTO> dlyNoteDisplay(DlyNoteDisplayDTO dlyNoteDisplayDTO);

}
