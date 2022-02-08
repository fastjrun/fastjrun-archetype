#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class PageQuery implements Serializable {
  /** 当前页 */
  private Integer current;
  /** 每页条数 */
  private Integer size;

  private static final long serialVersionUID = -2646524565649755149L;
}
