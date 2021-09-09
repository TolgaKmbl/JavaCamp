package kodlama.io.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvDto {
	private String companyName;
	private String jobName;
	private int numOfPosition;
	private Date dueDate;
	private Date releaseDate;
}