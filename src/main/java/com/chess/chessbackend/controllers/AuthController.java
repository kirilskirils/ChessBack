package com.chess.chessbackend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.chess.chessbackend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chess.chessbackend.models.User;
import com.chess.chessbackend.payload.request.LoginRequest;
import com.chess.chessbackend.payload.request.SignupRequest;
import com.chess.chessbackend.payload.response.JwtResponse;
import com.chess.chessbackend.payload.response.MessageResponse;
import com.chess.chessbackend.repository.UserRepository;
import com.chess.chessbackend.security.jwt.JwtUtils;
import com.chess.chessbackend.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController
{
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    /**
     * POST for signin
     * @param loginRequest request body
     * @return Response body with JWT token, user id and username
     */
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest)
    {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername()));
    }

    /**
     * POST for sign up
     * @param signUpRequest request body
     * @return Response message with success or failure
     */
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest)
    {
        if (userRepository.existsByUsername(signUpRequest.getUsername()))
        {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        User user = new User(signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
