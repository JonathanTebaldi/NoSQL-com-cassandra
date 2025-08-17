package com.talkevents.cassandra.repositories;

import com.talkevents.cassandra.models.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface UserRepositoy extends CassandraRepository<User, UUID> {
}
