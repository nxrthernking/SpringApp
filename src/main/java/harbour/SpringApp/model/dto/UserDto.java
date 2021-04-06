package harbour.SpringApp.model.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String password;
}
