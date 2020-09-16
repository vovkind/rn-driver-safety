import { NativeModules } from 'react-native';

type DriverSafetyType = {
  multiply(a: number, b: number): Promise<number>;
};

const { DriverSafety } = NativeModules;

export default DriverSafety as DriverSafetyType;
