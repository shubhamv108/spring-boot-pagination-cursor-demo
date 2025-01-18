package code.shubham.demo.pagination.dao;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class IdAuditorAware implements AuditorAware<Long> {

	@Override
	public Optional<Long> getCurrentAuditor() {
		return Optional.ofNullable(-1L);
	}

}