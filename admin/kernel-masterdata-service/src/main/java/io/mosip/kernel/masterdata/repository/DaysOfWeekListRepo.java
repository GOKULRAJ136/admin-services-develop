package io.mosip.kernel.masterdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.mosip.kernel.core.dataaccess.spi.repository.BaseRepository;
import io.mosip.kernel.masterdata.entity.DaysOfWeek;
import io.mosip.kernel.masterdata.entity.id.WeekDayId;

@Repository("daysOfWeekRepo")
public interface DaysOfWeekListRepo extends BaseRepository<DaysOfWeek, WeekDayId> {

	@Query("SELECT d.name from DaysOfWeek d where d.code=?1 and d.langCode=?2 and (d.isDeleted is null or d.isDeleted = false) and d.isActive = true")
	List<String> findBycodeAndlangCode(String dayCode, String langCode);

	@Query("FROM DaysOfWeek where langCode=?1 and (isDeleted is null or isDeleted = false) and isActive = true order by code asc")
	List<DaysOfWeek> findBylangCode(String langCode);

	@Query("FROM DaysOfWeek where code=?1 and (isDeleted is null or isDeleted = false) order by code asc")
	List<DaysOfWeek> findByCode(String code);

	@Query("FROM DaysOfWeek where (isDeleted is null or isDeleted = false) and isActive = true")
	List<DaysOfWeek> findDaysOfWeek();

	@Query("FROM DaysOfWeek where langCode=?1 and code=?2 and (isDeleted is null or isDeleted = false) order by code asc")
	DaysOfWeek findBylangCodeAndCode(String langCode,String code);

	@Query("SELECT d from DaysOfWeek d where d.langCode=?1 and d.isGlobalWorking=true and (d.isDeleted is null or d.isDeleted = false) and d.isActive = true")
	List<DaysOfWeek> findByAllGlobalWorkingTrue(String langCode);

	@Query("SELECT d from DaysOfWeek d where d.isGlobalWorking=true and (d.isDeleted is null or d.isDeleted = false) and d.isActive = true")
	List<DaysOfWeek> findByAllGlobalWorkingTrue();

}
