package io.mosip.admin.bulkdataupload.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.mosip.admin.bulkdataupload.entity.RegExceptionalHoliday;
import io.mosip.admin.bulkdataupload.entity.id.RegExceptionalHolidayID;
import io.mosip.kernel.core.dataaccess.spi.repository.BaseRepository;

@Repository("RegExceptionalHolidayRepo")
public interface RegExceptionalHolidayRepository
		extends BaseRepository<RegExceptionalHoliday, RegExceptionalHolidayID> {

	@Query("From RegExceptionalHoliday where registrationCenterId=?1 and langCode=?2 and (isDeleted is null or isDeleted = false) and isActive = true")
	public List<RegExceptionalHoliday> findByRegIdAndLangcode(String registrationCenterId, String langCode);

	@Query("From RegExceptionalHoliday where registrationCenterId=?1 and langCode=?2 and exceptionHolidayDate= ?3 and (isDeleted is null or isDeleted = false) and isActive = true")
	public RegExceptionalHoliday findByRegIdAndLangcodeAndExpHoliday(String registrationCenterId, String langCode,
			LocalDate exceptionHolidayDate);

	@Query("From RegExceptionalHoliday where langCode=?1 and (isDeleted is null or isDeleted = false) and isActive = true")
	public List<RegExceptionalHoliday> findByLangcode(String langCode);

	@Query("From RegExceptionalHoliday where registrationCenterId=?1  and exceptionHolidayDate= ?2 ")
	public Object findByRegIdAndExpHoliday(String registrationCenterId, LocalDate exceptionHolidayDate);

}
