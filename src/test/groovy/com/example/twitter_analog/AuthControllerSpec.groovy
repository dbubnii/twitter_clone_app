package com.example.twitter_analog

import com.example.twitter_analog.model.User
import com.example.twitter_analog.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath


@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerSpec extends Specification {

	@Autowired
	MockMvc mockMvc

	@Autowired
	UserRepository userRepository

	@Autowired
	PasswordEncoder passwordEncoder

	def "Register user should return status 201 and user details"() {
		given:
		def user = new User(username: "testuser", password: "password", email: "test@example.com")
		def jsonUser = new groovy.json.JsonBuilder(user).toString()

		when:
		def result = mockMvc.perform(post("/api/auth/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonUser))

		then:
		result.andExpect(status().isCreated())
		result.andExpect(jsonPath("$.username").value("testuser"))
		result.andExpect(jsonPath("$.email").value("test@example.com"))
	}

	def "Authenticate user with correct credentials should return status 200 and user details"() {
		given:
		def user = new User(username: "testuser", password: passwordEncoder.encode("password"), email: "test@example.com")
		userRepository.save(user)

		when:
		def result = mockMvc.perform(post("/api/auth/login")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("username", "testuser")
				.param("password", "password"))

		then:
		result.andExpect(status().isOk())
		result.andExpect(jsonPath("$.username").value("testuser"))
		result.andExpect(jsonPath("$.email").value("test@example.com"))
	}

	def "Authenticate user w
