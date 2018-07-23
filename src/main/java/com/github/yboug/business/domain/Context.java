package com.github.yboug.business.domain;


import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * Context of application defined by : - Lawn : define ShapeLimit - Mowers :
 * list of mowers and they command to execute
 * 
 * @author Youness
 *
 */
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Context {

	private Lawn lawn;
	private Map<Mower, List<MowerCommand>> mowers;

}
