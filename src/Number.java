
public class Number {

        private String Number;
        private String Network;
        private String Activation_Date;
        private String Deactivation_Date;
        private String Status;

        public Number(String number, String network, String activation_Date, String deactivation_Date, String status) {
            Number = number;
            Network = network;
            Activation_Date = activation_Date;
            Deactivation_Date = deactivation_Date;
            Status = status;
        }

        public String getNumber() {
            return Number;
        }

        public void setNumber(String number) {
            Number = number;
        }

        public String getNetwork() {
            return Network;
        }

        public void setNetwork(String network) {
            Network = network;
        }

        public String getActivation_Date() {
            return Activation_Date;
        }

        public void setActivation_Date(String activation_Date) {
            Activation_Date = activation_Date;
        }

        public String getDeactivation_Date() {
            return Deactivation_Date;
        }

        public void setDeactivation_Date(String deactivation_Date) {
            Deactivation_Date = deactivation_Date;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String status) {
            Status = status;
        }



    }

